import request from '@/utils/request'

// 查询护理项目列表
export function listNursingProject(query) {
  return request({
    url: '/nursing/NursingProject/list',
    method: 'get',
    params: query
  })
}

// 查询护理项目详细
export function getNursingProject(id) {
  return request({
    url: '/nursing/NursingProject/' + id,
    method: 'get'
  })
}

// 新增护理项目
export function addNursingProject(data) {
  return request({
    url: '/nursing/NursingProject',
    method: 'post',
    data: data
  })
}

// 修改护理项目
export function updateNursingProject(data) {
  return request({
    url: '/nursing/NursingProject',
    method: 'put',
    data: data
  })
}

// 删除护理项目
export function delNursingProject(id) {
  return request({
    url: '/nursing/NursingProject/' + id,
    method: 'delete'
  })
}
//查询所有护理项目
export function getAllProjects() {
  return request({
    url: '/nursing/NursingProject/all',
    method: 'get'
  })
}