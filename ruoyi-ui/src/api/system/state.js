import request from '@/utils/request'

// 查询预约功能列表
export function listState(query) {
  return request({
    url: '/system/state/list',
    method: 'get',
    params: query
  })
}

// 查询预约功能详细
export function getState(number) {
  return request({
    url: '/system/state/' + number,
    method: 'get'
  })
}

// 新增预约功能
export function addState(data) {
  return request({
    url: '/system/state',
    method: 'post',
    data: data
  })
}

// 修改预约功能
export function updateState(data) {
  return request({
    url: '/system/state',
    method: 'put',
    data: data
  })
}

// 删除预约功能
export function delState(number) {
  return request({
    url: '/system/state/' + number,
    method: 'delete'
  })
}

// 导出预约功能
export function exportState(query) {
  return request({
    url: '/system/state/export',
    method: 'get',
    params: query
  })
}