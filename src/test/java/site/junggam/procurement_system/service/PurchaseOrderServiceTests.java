package site.junggam.procurement_system.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.junggam.procurement_system.dto.PageRequestDTO;
import site.junggam.procurement_system.dto.PageResultDTO;
import site.junggam.procurement_system.dto.PurchaseOrderDTO;
import site.junggam.procurement_system.entity.PurchaseOrder;

import java.util.List;


@SpringBootTest
public class PurchaseOrderServiceTests {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Test
    @Transactional
    public void testGetPurchaseOrder() {
        System.out.println("여기다!!!!!!!!!!!!!!!!!!!!!!!");
        String purchaseOrderCode="PO1";
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderService.getPurchaseOrder(purchaseOrderCode);
        System.out.println(purchaseOrderDTO);
//        System.out.println(purchaseOrderDTO.getProcurementPlanDTO());
//        System.out.println(purchaseOrderDTO.getInspectionPlanDTOList());
    }

    @Test
    @Transactional
    public void getPurchaseOrders() {
        PageResultDTO<PurchaseOrderDTO, PurchaseOrder> purchaseOrderDTOList=purchaseOrderService.getPurchaseOrderList(PageRequestDTO.builder().page(1).size(10).build());
        System.out.println(purchaseOrderDTOList);
    }

}
