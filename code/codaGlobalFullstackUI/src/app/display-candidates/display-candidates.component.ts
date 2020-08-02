import { Component, OnInit } from '@angular/core';
import { CodaService } from '../coda.service';

@Component({
  selector: 'app-display-candidates',
  templateUrl: './display-candidates.component.html',
  styleUrls: ['./display-candidates.component.css']
})
export class DisplayCandidatesComponent implements OnInit {

  constructor(private service : CodaService) { }

  candidateList;
  totalVotes;

  ngOnInit() {
    this.service.displayAllCandidate().subscribe(
      data=>{this.candidateList=data}
    )

    this.service.displayAllVotes().subscribe(
      data=>{this.totalVotes=data.message}
    )

}
}
