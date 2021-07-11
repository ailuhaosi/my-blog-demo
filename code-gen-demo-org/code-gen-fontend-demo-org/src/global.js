module.exports = {
  BASE_URL: process.env.NODE_ENV === 'production' ? '' : 'http://localhost:8080',
  BASE_API: process.env.NODE_ENV === 'production' ? '' : '/api',
  IS_MOCK: false
}
