package com.pjh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pjh.entity.TbUser;
import com.pjh.mapper.TbUserMapper;
import com.pjh.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author bozhiqiang
 * @since 2021-05-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
