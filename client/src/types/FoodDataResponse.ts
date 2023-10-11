import { FoodData } from "./FoodData"

export interface FoodDataResponse {
    _embedded:{foodList: FoodData[]},
    _links:{},
}