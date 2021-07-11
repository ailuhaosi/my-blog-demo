import request from '@/utils/request'

export function uploadImg(data) {
  return request({
    url: '/pic/upload',
    method: 'post',
    headers: {
      'Content-Type': 'multipart/form-data'
    },
    data
  })
}

export async function getDevStatus(data) {
  return request({
    url: `/dev/redis/get/${data}`,
    method: 'get'
  })
}
