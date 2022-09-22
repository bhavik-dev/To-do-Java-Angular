import { Component, OnInit } from '@angular/core';
import { Item } from './core/interface/item.interface';
import { TodoService } from './core/services/todo.service';
import { Constants } from './core/config/constant';
import { GlobalData } from './core/config/globalToDoData';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title: string = 'todoapp';
  filter: 'all' | 'active' | 'done' = 'all';
  allItems = [
    { id: 1, desc: 'eat', done: true },
    { id: 2, desc: 'sleep', done: false },
    { id: 3, desc: 'play', done: false },
    { id: 4, desc: 'laugh', done: false },
  ];
  todoItems!: Item[];
  item: Item = { desc: "", done: false, id: -1 };

  constructor(private _todoService: TodoService,
    private globalData: GlobalData) {
  }

  get items() {
    if (this.filter == 'all') {
      return this.todoItems
    }
    return this.todoItems.filter(item => this.filter === 'done' ? item.done : !item.done);
  }

  ngOnInit(): void {
    this.getAllToDoList();
    // throw new Error('Method not implemented.');
  }

  getAllToDoList() {
    this._todoService.getAll(Constants.baseUrl + 'todo')
      .subscribe(
        (response: Item[]) => {
          this.todoItems = response;
        }
      );
  }


  addItem(desc: string) {
    if (desc == "") {
      return;
    }
    debugger;
    this.item.desc = desc;
    this.item.done = false;
    this.item.id = 9;
    this._todoService.create(this.item, Constants.baseUrl + 'todo')
      .subscribe(
        (response: Item[]) => {
        }
      );
    this.getAllToDoList();
    // this.todoItems.unshift({
    //   id: 1,
    //   desc,
    //   done: false,
    // });
  }

  remove(item: Item) {
    this._todoService.delete(item.id, Constants.baseUrl + 'todo')
      .subscribe(
        (response: Item[]) => {
        }
      );
    this.getAllToDoList();
    // this.todoItems.splice(this.todoItems.indexOf(item), 1);
  }

}
