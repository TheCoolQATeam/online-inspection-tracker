import Path from './path'
import service from './service'
import { resfulParamsToUrl } from '../common/resfulUrl'

/**
 * 列表
 */
export const getOnlinespatrolList = (params: any) => {
  return service.get(Path.getOnlinespatrolList, { params })
}

/**
 * 新增
 * @param { id } params
 */
export const addOnlinespatrol = (params: any) => {
  return service.post(Path.addOnlinespatrol, params)
}

/**
 * 修改用例基本信息
 * @param { id } params
 */
export const updataCaseInfo = (params: any) => {
  return service.post(Path.updataCaseInfo, params)
}

/**
 * 删除
 *  @param { id } params
 */
export const delOnlinespatrol = (params: any) => {
  return service.get(resfulParamsToUrl(Path.delOnlinespatrol, params), { params })
}

/**
 * 查询用例执行情况
 *  @param { id } params
 */
export const getCaseInfo = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getCaseInfo, params), { params })
}

/**
 * 查询用例基本信息
 *  @param { id } params
 */
export const getCaseBaseInfo = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getCaseBaseInfo, params), { params })
}
/**
 * 查询失败的用例
 *  @param { id } params
 */
export const getFailedCaseInfo = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getFailedCaseInfo, params), { params })
}
/**
 * 查询>3s的用例
 *  @param { id } params
 */
export const getTimeoutCaseInfo = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getTimeoutCaseInfo, params), { params })
}
/**
 * 查询H5巡检汇总报告数据
 *  @param { id } params
 */
export const getH5Stat = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getH5Stat, params), { params })
}
/**
 * 巡检记录
 *  @param { id } params
 */
export const getTestPlanList = (params: any) => {
  return service.get(resfulParamsToUrl(Path.getTestPlanList, params), { params })
}

export const resetDatum = (params: any) => {
  return service.get(resfulParamsToUrl(Path.resetDatum, params), { params })
}
