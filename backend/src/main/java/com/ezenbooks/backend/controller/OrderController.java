package com.ezenbooks.backend.controller;

import com.ezenbooks.backend.BootpayApi;
import com.ezenbooks.backend.dto.BootPayOrderDto;
import com.ezenbooks.backend.pay.Order;
import com.ezenbooks.backend.pay.OrderForm;
import com.ezenbooks.backend.pay.orderItem;
import com.ezenbooks.backend.pay.request.Cancel;
import com.ezenbooks.backend.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class OrderController {

	
    private final OrderService orderService;

    
    @RequestMapping(value ="/order", method=RequestMethod.POST)
    public String pay(OrderForm form, Model model) {
    	
        //orderItem orderitem = orderService.createItem(form);
        Order order = orderService.createOrder(form);
        System.out.println("pay실행");
        System.out.println(order.getId());

        return order.getId().toString() ;
    }

    @RequestMapping(value ="/order/complete", method=RequestMethod.GET)
    public String completePay(@RequestParam("id") Long id) {
        orderService.completeOrder(id);
        System.out.println("결제완료");
        return id.toString();
    }

    @RequestMapping(value ="/order/delete", method=RequestMethod.GET)
    public String deletePay(@RequestParam("id") Long id)  {
        orderService.deleteOrder(id);
        System.out.println("id: "+ id);

  
        return id.toString();
    }

    /**
     * 결제 검증
     * @param
     * @return
     * 
     * 서버사이드 코드
     */
    @GetMapping("/order/confirm")
    public ResponseEntity confirmPay(@RequestParam("receipt_id") String receipt_id) throws Exception {
        String getDataJson = "";
        BootPayOrderDto dto = null;
        
        System.out.println(receipt_id);
        
      //Access Token 발급 받기
        String rest_application_id = "63eb089b966b74001e2ef7db";
        String private_key = "p6LAH1F0TLsHu7T4AghFuqzCLMBx1C3RdbQ2+wKqoDc=";

        BootpayApi api = new BootpayApi(
                rest_application_id,
                private_key
        );
        api.getAccessToken();
        
        
        try {

            HttpResponse res = api.verify(receipt_id);
            getDataJson = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
            System.out.println(getDataJson);

            ObjectMapper objectMapper = new ObjectMapper();
            dto = objectMapper.readValue(getDataJson, BootPayOrderDto.class);
            System.out.println(dto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        long orderId = Long.parseLong(dto.getData().getOrder_id());
        Order order = orderService.findOrder(orderId);
        int price = order.getItem().getPrice();
    	System.out.println(price);
    	System.out.println(order);

        if (dto.getStatus() == 200) {

        	
            //status가 1이고
            if (dto.getData().getPrice() == price && dto.getData().getStatus() == 1) {
                //결제 완료
                orderService.completeOrder(orderId);
                return ResponseEntity.ok(getDataJson);
            }
        }

        //서버 검증 오류시
        Cancel cancel = new Cancel();
        cancel.receipt_id = receipt_id;
        cancel.name = "관리자";
        cancel.reason = "서버 검증 오류";

        //결제 오류 로그
        orderService.failOrder(orderId);
        String cancelDataJson = "";
        try {
            HttpResponse res = api.cancel(cancel);
            cancelDataJson = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
            System.out.println(cancelDataJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("결제실패");
    }
}
