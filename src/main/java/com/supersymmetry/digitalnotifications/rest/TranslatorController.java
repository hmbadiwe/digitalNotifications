package com.supersymmetry.digitalnotifications.rest;

import com.supersymmetry.digitalnotifications.domain.Order;
import com.supersymmetry.digitalnotifications.domain.TranslatorResponseBody;
import com.supersymmetry.digitalnotifications.domain.TranslatorPayload;
import com.supersymmetry.digitalnotifications.service.OrderService;
import com.supersymmetry.digitalnotifications.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/order/translate")
public class TranslatorController {
    @Autowired
    private TranslatorService translatorService;

    @Autowired
    private OrderService orderService;
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity translate( @RequestBody TranslatorPayload payload ){
        Order order = orderService.findByOrderNumber( payload.getOrderId(), payload.getOrderType());
        if( order != null ){
            TranslatorResponseBody t = new TranslatorResponseBody(translatorService.translate( payload.getMessageBody(), order ) );
            return new ResponseEntity<TranslatorResponseBody>(t, HttpStatus.OK );

        }
        return new ResponseEntity( String.format("Order with order number(%s) not found", payload.getOrderId()) , HttpStatus.NOT_FOUND);
    }




}
