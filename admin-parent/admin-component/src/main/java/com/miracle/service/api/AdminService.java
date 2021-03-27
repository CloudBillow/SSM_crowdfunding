package com.miracle.service.api;

import com.miracle.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miracle
 * @version v1.0
 * @description AdminService
 * @date 2021-03-26 20:50
 */
public interface AdminService {
    /**
     * 保存Admin
     * @param admin Admin
     */
    void saveAdmin(Admin admin);

    List<Admin> getAll();
}
