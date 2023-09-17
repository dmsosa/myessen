import axios, { AxiosPromise } from "axios";
import { FoodData } from "../interface/FoodData";
import { useQuery }
const API_URL = 'http://localhost:8080';
const fetchData = async(): AxiosPromise<FoodData> => {
    const r = axios.get(API_URL+'/core');
    return r
}

export function useFoodData(){
    const query = useQuery
}