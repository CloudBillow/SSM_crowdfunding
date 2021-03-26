package com.miracle.service.impl;

import com.miracle.entity.Admin;
import com.miracle.mapper.AdminMapper;
import com.miracle.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miracle
 * @version v1.0
 * @description TODO
 * @date 2021-03-26 20:50
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
