package com.daemu.authcenter.component;

import com.daemu.authcenter.system.model.SysUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description  jwt自定义增强器(根据自己的业务需求添加非敏感字段)
 * @author daemu
 * @date 2021-01-20 23:14
 */
public class AuthTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        SysUserDetails memberDetails = (SysUserDetails) authentication.getPrincipal();

        final Map<String, Object> additionalInfo = new HashMap<>();

        final Map<String, Object> retMap = new HashMap<>();

        //todo 这里暴露memberId到Jwt的令牌中,后期可以根据自己的业务需要 进行添加字段
        additionalInfo.put("memberId",memberDetails.getSysUser().getId());
        additionalInfo.put("nickName",memberDetails.getSysUser().getNickname());
        additionalInfo.put("integration",memberDetails.getSysUser().getIntegration());

        retMap.put("additionalInfo",additionalInfo);

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(retMap);

        return accessToken;
    }
}
