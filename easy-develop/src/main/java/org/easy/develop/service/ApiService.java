package org.easy.develop.service;

import java.util.List;

import org.easy.develop.common.domain.DevApi;

public interface ApiService {

	/**
	 * 新增api接口信息
	 * @param api
	 * @return Long id
	 */
	Long addApi(DevApi api);

	/**
	 * 根据id查询api接口信息
	 * @param id
	 * @return DevApi
	 */
	DevApi getApiById(Long id);

	/**
	 * 查询api接口列表
	 * @return List<DevApi>
	 */
	List<DevApi> listApi();

	/**
	 * 根据id更新api接口信息
	 * @param api
	 * @return DevApi
	 */
	DevApi updateApi(DevApi api);

}