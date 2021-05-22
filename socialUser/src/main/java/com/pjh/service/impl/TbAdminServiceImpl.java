package com.pjh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pjh.entity.TbAdmin;
import com.pjh.mapper.TbAdminMapper;
import com.pjh.service.TbAdminService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@Service
public class TbAdminServiceImpl extends ServiceImpl<TbAdminMapper, TbAdmin> implements TbAdminService {

}
