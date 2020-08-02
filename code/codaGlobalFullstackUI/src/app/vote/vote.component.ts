import { Component, OnInit } from '@angular/core';
import { CodaService } from '../coda.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent implements OnInit {

  candidateId;
  message;
  errorMessage;

  showErrorMessage;
  showMessage;

  constructor(private service : CodaService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.router.paramMap.subscribe(params=>{
      this.candidateId= params.get('candidateId');
  })

  this.service.addVote(this.candidateId).subscribe(
    data=>{this.message=data.message, this.showMessage=true},
    error=>{this.errorMessage=error.error.message, this.showErrorMessage=true}


  )

}
}

