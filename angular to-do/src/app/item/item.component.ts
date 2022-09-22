import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Constants } from '../core/config/constant';
import { Item } from "../core/interface/item.interface";
import { TodoService } from '../core/services/todo.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent {

  editable = false;
  // todoItems!: Item[];

  @Input() item!: Item;
  @Input() newItem!: string;
  @Output() remove = new EventEmitter<Item>();

  constructor(
    private _todoService: TodoService
  ) { }

  saveItem(desc: string, item: Item) {
    debugger;
    if (!item.desc) return;
    this.editable = false;
    this.item.desc = desc;
    this._todoService.update(item.id, this.item, Constants.baseUrl + 'todo')
      .subscribe(
        (response: Item[]) => {
          // this.todoItems = response;
          // console.log(this.todoItems);
          // GlobalData.todoData = response;
          // console.log(GlobalData.todoData);
        }
      );
  }
}
