import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PessoaService } from '../../servico/pessoa.service';
import { Data } from '../../module/data';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{

  formulario!: FormGroup;

  dados!:Data;

  constructor(private servico:PessoaService, private fm: FormBuilder, private route:Router){}

  ngOnInit(): void {
    this.iniciarForm();
    console.log(this.dados)
  }


  public iniciarForm(){
    this.formulario = this.fm.group({
      nome: ['', Validators.required],
      email:['', Validators.required],
      phone:['', Validators.required]
    });
  }

  public salvar(){
    this.dados = this.formulario.value
    this.servico.post(this.dados).subscribe(
      res => res
    )
    this.formulario.reset()
    this.route.navigate(['/list'])
  }

}
