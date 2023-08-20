import axios from 'axios';

let Axios = axios.create({
    baseURL: 'http://localhost:8080/api'
});

Axios.interceptors.request.use(
    function add_jwt(config){
      if(window.localStorage["jwt"]){
        config.headers["Authorization"]="Bearer " + window.localStorage["jwt"]
      }
      return config
    }
  )

export default Axios;