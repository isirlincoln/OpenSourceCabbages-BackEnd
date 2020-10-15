package com.osc.shippinginfo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShippingInfoController {

    @Autowired
    ShippingInfoRepository dao;

    // READ
    @GetMapping("/shippinginfo")
    public List<ShippingInfo> getShippingInfo() {
        List<ShippingInfo> foundShippingInfo = dao.findAll();
        return foundShippingInfo;
    }

    // CREATE
    @PostMapping("/shippinginfo")
    public ResponseEntity<ShippingInfo> postShippingInfo(@RequestBody ShippingInfo shippingInfo) {
        // This saves to the osc database using repository.
        ShippingInfo createShippingInfo = dao.save(shippingInfo);
        // Gives a response to include our status code
        return ResponseEntity.ok(createShippingInfo);
    }

    // UPDATE
    @PutMapping("/shippinginfo/{id}")
    public ResponseEntity<ShippingInfo> putShippingInfo(@PathVariable Integer id, @RequestBody ShippingInfo shippingInfo) {
        ShippingInfo foundShippingInfo = dao.findById(id).orElse(null);
        if (foundShippingInfo == null) {
            return ResponseEntity.notFound().header("Message", "Shipping information is not found").build();
        } else {
            if (shippingInfo.getAddress() != null) {
                foundShippingInfo.setAddress(shippingInfo.getAddress());
            }
            if (shippingInfo.getCity() != null) {
                foundShippingInfo.setCity(shippingInfo.getCity());
            }
            if(shippingInfo.getState() != null){
                foundShippingInfo.setState(shippingInfo.getState());
            }
            if(shippingInfo.getZipcode() == 0 && (Integer.toString(shippingInfo.getZipcode()).length())<5){
                foundShippingInfo.setZipcode(shippingInfo.getZipcode());
            }
            if(shippingInfo.getCountry() != null){
                foundShippingInfo.setCountry(shippingInfo.getCountry());
            }
            if(shippingInfo.getUserId() != 0){
                foundShippingInfo.setUserId(shippingInfo.getUserId());
            }
            dao.save(foundShippingInfo);
        }

        return ResponseEntity.ok(foundShippingInfo);
    }

    // DELETE
    @DeleteMapping("shippingInfo{id}")
    public ResponseEntity<ShippingInfo> deleteShippingInfo(@PathVariable(value = "id") Integer id) {
        ShippingInfo foundShippingInfo = dao.findById(id).orElse(null);
        if (foundShippingInfo == null) {
            return ResponseEntity.notFound().header("Message","Shipping Info is not found").build();
        } else {
            dao.delete(foundShippingInfo);
        }
        return ResponseEntity.ok().build();
    }

}
