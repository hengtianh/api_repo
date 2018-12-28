package org.easy.develop.service.impl;

import java.util.Date;
import java.util.List;

import org.easy.develop.common.domain.DevApi;
import org.easy.develop.dao.DevApiMapper;
import org.easy.develop.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	private DevApiMapper apiMapper;
	
	/* (non-Javadoc)
	 * @see org.easy.develop.service.impl.ApiService#addApi(org.easy.develop.common.domain.DevApi)
	 */
	@Override
	@Transactional()
	public Long addApi(DevApi api) {
		apiMapper.insert(api);
		
		return api.getId();
	}
	
	/* (non-Javadoc)
	 * @see org.easy.develop.service.impl.ApiService#getApiById(java.lang.Long)
	 */
	@Override
	public DevApi getApiById(Long id) {
		DevApi api = apiMapper.selectByPrimaryKey(id);
		return api;
	}
	
	/* (non-Javadoc)
	 * @see org.easy.develop.service.impl.ApiService#listApi()
	 */
	@Override
	public List<DevApi> listApi() {
		return apiMapper.selectByExample(null);
	}
	
	/* (non-Javadoc)
	 * @see org.easy.develop.service.impl.ApiService#updateApi(org.easy.develop.common.domain.DevApi)
	 */
	@Override
	@Transactional()
	public DevApi updateApi(DevApi api) {
		api.setGmtModified(new Date());
		apiMapper.updateByPrimaryKeySelective(api);
		return api;
	}
}
