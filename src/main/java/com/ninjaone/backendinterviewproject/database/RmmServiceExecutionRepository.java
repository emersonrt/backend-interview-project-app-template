package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.dto.output.CostsByDeviceResponseDto;
import com.ninjaone.backendinterviewproject.model.RmmServiceExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RmmServiceExecutionRepository extends JpaRepository<RmmServiceExecution, Long> {

    @Query(value = "SELECT d.id as deviceId, d.systemName as systemName, d.deviceType as deviceType, SUM(rs.cost * rse.quantity) as totalCosts \n" +
            "FROM RmmServiceExecution rse \n" +
            "JOIN rse.rmmService rs \n" +
            "JOIN rse.device d \n" +
            "WHERE d.id = :deviceId GROUP BY d.id")
    Optional<CostsByDeviceResponseDto> calculateCostsByDeviceId(Long deviceId);

}