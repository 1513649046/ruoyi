import request from '@/utils/request'

// 查询更多资讯列表
export function listType(query) {
  return request({
    url: '/system/type/list',
    method: 'get',
    params: query
  })
}

// 查询更多资讯详细
export function getType(typeId) {
  return request({
    url: '/system/type/' + typeId,
    method: 'get'
  })
}

// 新增更多资讯
export function addType(data) {
  return request({
    url: '/system/type',
    method: 'post',
    data: data
  })
}

// 修改更多资讯
export function updateType(data) {
  return request({
    url: '/system/type',
    method: 'put',
    data: data
  })
}

// 删除更多资讯
export function delType(typeId) {
  return request({
    url: '/system/type/' + typeId,
    method: 'delete'
  })
}

// 导出更多资讯
export function exportType(query) {
  return request({
    url: '/system/type/export',
    method: 'get',
    params: query
  })
}