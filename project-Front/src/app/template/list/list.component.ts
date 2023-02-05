import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { PessoaService } from '../../servico/pessoa.service';
import { FormGroup, FormBuilder } from '@angular/forms';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{



  select: Data | any;

  form!: FormGroup;

  ativo: boolean= true;

  valor!:Data;

 constructor(private pessoaService: PessoaService, private fm:FormBuilder) {}



  ngOnInit(): void {
    this.listar()
    this.formView()
  }

  listar(){
    this.pessoaService.getAll().subscribe(res =>{
      this.select =   res
    })
  }

  selectInfo(valor: number){
   this.pessoaService.geById(valor).subscribe(
    res => this.form.patchValue(res)
   )
    if(this.ativo){
      this.ativo = false
    }else{
      this.ativo = true
    }
    this.listar()
  }

  formView(){
    this.form = this.fm.group({
      id: [''],
      nome: [''],
      email: [''],
      phone: ['']
    })
  }

  cancel(){
   this.ativo = true
    window.location.reload()
  }

  upadate(){
    this.pessoaService.update(this.form.value).subscribe(
      res => res
    )
    this.cancel()
  }


  delete(id:number){
    this.pessoaService.delete(id).subscribe(
      res => res
    )
    window.location.reload()
  }
}
