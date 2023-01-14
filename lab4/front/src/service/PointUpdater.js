import {addPoint, clearAll} from "../redux/pointSlice";
import clearStoreInLogout from "./LogoutUtil";
import createToast from "./Toaster";

function pointUpdater(dispatch, pointService, jwtToken){
    dispatch(clearAll());
    pointService.getPoints(jwtToken).then(
        result => {
            for (let d of result.data){
                dispatch(addPoint(d));
            }
        }
    ).catch(reason => {
        if (reason.response.status === 401){
            clearStoreInLogout(dispatch);
            createToast("Сессия истекла<br>Нужно войти заново");
        }
    })
}

export default pointUpdater;