
import { FoodData } from "../interface/FoodData";
import axios, {AxiosPromise} from 'axios';
import { useQuery } from "@tanstack/react-query";
import { FoodDataResponse } from "../interface/FoodDataResponse";

const API_URL = 'http://localhost:8080';

const fetchData = async (): AxiosPromise<FoodDataResponse> => {
    const response = axios.get(API_URL + '/core');
    return response;
}

export function useFoodData(){
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['food-data'],
        retry: 2
    })
    console.log(query.data?.data)
    return {
        ...query,
        data: query.data?.data
    }
}