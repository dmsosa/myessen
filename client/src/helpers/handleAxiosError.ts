import { AxiosError } from "axios";

function handleAxiosError(error:AxiosError<String, String>) {
    if (!error.response) {
        console.log(error)
    }
    
    const responseStatus = error.response?.status; 
    //zuMachen, FehlerErhalten zu arbeiten
    // if (typeof responseStatus === undefined ) {
    //     const status = null;
    // } else {
    //     const status = responseStatus;
    // }
    // if ([401, 403, 404, 422, 500].includes(status)) {
    //     console.log(error.response, data.errors.body[0]);
    //     throw data.errors.body[0];
    // }

    console.dir(error);
}

export default handleAxiosError;