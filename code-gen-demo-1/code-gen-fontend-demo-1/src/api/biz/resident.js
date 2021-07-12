import request from '@/utils/request'

export function getResidentInfo(params) {
    return request({
        url: `/biz/resident/info`,
        method: 'get',
        params
    })
}

export function getResidentList(params) {
    return request({
        url: '/biz/resident/list',
        method: 'get',
        params
    })
}

export function saveResident(data) {
    return request({
        url: '/biz/resident/save',
        method: 'post',
        data
    })
}

export function updateResident(data) {
    return request({
        url: '/biz/resident/update',
        method: 'put',
        data
    })
}

export function deleteResidentByIds(data) {
    return request({
        url: `/biz/resident/delete`,
        method: 'delete',
        data
    })
}
