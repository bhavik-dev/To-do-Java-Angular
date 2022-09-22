import { Injectable } from "@angular/core";
import { Item } from "../interface/item.interface";

@Injectable()
export class GlobalData {
    public static todoData: Item[];
}