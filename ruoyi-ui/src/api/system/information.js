import request from '@/utils/request'





// 查询资讯列表
export function listInformation(query) {
  return request({
    url: '/system/information/list',
    method: 'get',
    params: query
    
  })
}

// 查询资讯详细
export function getInformation(infoId) {
  return request({
    url: '/system/information/' + infoId,
    method: 'get'
  })
}

// 新增资讯
export function addInformation(data) {
  return request({
    url: '/system/information',
    method: 'post',
    data: data
  })
}

// 修改资讯
export function updateInformation(data) {
  return request({
    url: '/system/information',
    method: 'put',
    data: data
  })
}

// 删除资讯
export function delInformation(infoId) {
  return request({
    url: '/system/information/' + infoId,
    method: 'delete'
  })
}

// 导出资讯
export function exportInformation(query) {
  return request({
    url: '/system/information/export',
    method: 'get',
    params: query
  })
}
