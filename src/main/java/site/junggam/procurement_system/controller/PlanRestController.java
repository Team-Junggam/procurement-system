package site.junggam.procurement_system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.junggam.procurement_system.dto.*;
import site.junggam.procurement_system.entity.ProcurementPlan;
import site.junggam.procurement_system.entity.Product;
import site.junggam.procurement_system.entity.ProductionPlan;
import site.junggam.procurement_system.entity.Warehousing;
import site.junggam.procurement_system.service.MaterialService;
import site.junggam.procurement_system.service.PlanService;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanRestController {

    private final PlanService planService;

    @GetMapping(value = "/productListSearching", produces = "application/json")
    public ResponseEntity<List<ProductDTO>> getProductList(@RequestParam("keyword")String keyword) {
        log.info("받은 키워드는 "+keyword);
        List<ProductDTO> productDTOList = planService.getProductListSearching(keyword);
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/unitListSearching", produces = "application/json")
    public ResponseEntity<List<UnitDTO>> getUnitList(@RequestParam("keyword")String keyword) {
        log.info("받은 키워드는 "+keyword);
        List<UnitDTO> unitDTOList = planService.getUnitListSearching(keyword);
        return new ResponseEntity<>(unitDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/materialListSearching", produces = "application/json")
    public ResponseEntity<List<MaterialDTO>> getMaterialList(@RequestParam("keyword")String keyword) {
        log.info("받은 키워드는 "+keyword);
        List<MaterialDTO> materialDTOList = planService.getMaterialListSearching(keyword);
        return new ResponseEntity<>(materialDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/unitBomList/{unitCode}")
    public ResponseEntity<List<UnitBomDTO>> getUnitBomLit(@PathVariable("unitCode") String unitCode) {
        return new ResponseEntity<>(planService.getUnitBomList(unitCode), HttpStatus.OK);
    }

    @GetMapping(value = "/productBomList/{productCode}")
    public ResponseEntity<List<ProductBomDTO>> getProductBomLit(@PathVariable("productCode") String productCode) {
        return new ResponseEntity<>(planService.getProductBomList(productCode), HttpStatus.OK);
    }

    @PostMapping(value = "/registerProductionPlan")
    public ResponseEntity<String> resisterProductionPlan(@RequestBody ProductionPlanDTO productionPlanDTO){
        log.info("생산계획 레스트컨트롤러 집입");
        log.info("받은 값"+productionPlanDTO);
        planService.insertProductionPlan(productionPlanDTO);
        log.info("생산계획처리 완료!!!");
        return new ResponseEntity<>("생산계획등록", HttpStatus.OK);
    }

    @GetMapping(value = "/productionPlanList", produces = "application/json")
    public ResponseEntity<PageResultDTO<ProductionPlanDTO, ProductionPlan>> getProductionPlanList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<ProductionPlanDTO, ProductionPlan> productionPlanDTOList = planService.getProductionPlanList(pageRequestDTO);
        return new ResponseEntity<>(productionPlanDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/productionPlanGet/{productionPlanCode}")
    public ResponseEntity<ProductionPlanDTO> getProductionPlan(@PathVariable("productionPlanCode") String productionPlanCode) {
        return new ResponseEntity<>(planService.getProductionPlan(productionPlanCode), HttpStatus.OK);
    }

    @GetMapping(value = "/procurementPlanList", produces = "application/json")
    public ResponseEntity<PageResultDTO<ProcurementPlanDTO, ProcurementPlan>> getProcurementList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<ProcurementPlanDTO, ProcurementPlan> procurementPlanDTOList = planService.getProcurementPlanList(pageRequestDTO);
        return new ResponseEntity<>(procurementPlanDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/procurementPlanGet/{procurementPlanCode}")
    public ResponseEntity<ProcurementPlanDTO> getProcurementPlan(@PathVariable("procurementPlanCode") String procurementPlanCode) {
        return new ResponseEntity<>(planService.getProcurementPlan(procurementPlanCode), HttpStatus.OK);
    }

    @PostMapping(value = "/registerEstimate")
    public ResponseEntity<String> resisterEstimate(@RequestBody EstimateDTO estimateDTO){
        log.info("견적 레스트컨트롤러 집입");
        log.info("견적 받은 값"+estimateDTO);
        String estimateCode=planService.resisterEstimate(estimateDTO);
        log.info("견적 처리 완료!!!");
        return new ResponseEntity<>(estimateCode, HttpStatus.OK);
    }
    @PostMapping(value = "/registerContract")
    public ResponseEntity<String> resisterContract(@RequestBody ContractDTO contractDTO){
        log.info("견적 레스트컨트롤러 집입");
        log.info("견적 받은 값"+contractDTO);
        String contractCode=planService.resisterContract(contractDTO);
        log.info("견적 처리 완료!!!");
        return new ResponseEntity<>(contractCode, HttpStatus.OK);
    }

    @PatchMapping("/contract/{contractCode}")
    public ResponseEntity<String> contractModify(@RequestBody ContractDTO contractDTO){
        log.info(contractDTO);
        String contractCode=planService.modifyContract(contractDTO);
        return new ResponseEntity<>(contractCode, HttpStatus.OK);
    }

    @PatchMapping("/procurementPlan/{procurementPlanCode}")
    public ResponseEntity<String> procurementPlanModify(@RequestBody ProcurementPlanDTO procurementPlanDTO){
        log.info("검수수정 레스트컨트롤러 집입");
        log.info(procurementPlanDTO);
        String procurementPlanCode=planService.modifyProcurementPlan(procurementPlanDTO);
        return new ResponseEntity<>(procurementPlanCode, HttpStatus.OK);
    }

}
