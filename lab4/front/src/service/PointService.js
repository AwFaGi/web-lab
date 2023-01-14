import axios from "axios";

const API_URL="http://localhost:8080/points/"

class PointService {
    getPoints(jwtToken){
        return axios.get(API_URL + "list", {
            headers: {
                'Authorization': 'Bearer ' + jwtToken
            }
        })
    };

    // todo change over post
    sendPoint(x, y, r, jwtToken){
        return axios.post(API_URL + "add", {
                    'x': x,
                    'y': y,
                    'r': r
                },{
            headers: {
                'Authorization': 'Bearer ' + jwtToken
            }
        })
    };

}

export default PointService;