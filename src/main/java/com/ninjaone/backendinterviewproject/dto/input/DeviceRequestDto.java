package com.ninjaone.backendinterviewproject.dto.input;

import com.ninjaone.backendinterviewproject.model.DeviceType;

public class DeviceRequestDto {

    private final Integer id = null;
    private final String systemName;
    private final DeviceType deviceType;

    public DeviceRequestDto(String systemName, DeviceType deviceType) {
        this.systemName = systemName;
        this.deviceType = deviceType;
    }

    public Integer getId() {
        return id;
    }

    public String getSystemName() {
        return systemName;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }
}
