import axios from "axios";

const instance = axios.create({
    baseURL : "https://api.themoviedb.org/3",
    params : {
        api_key : "3237dc80fa954cf3961586da17b4ac29",
        language : "ko-KR"
    },
})

export default instance;