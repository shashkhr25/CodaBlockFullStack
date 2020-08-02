import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CodaService {

  constructor(private http : HttpClient) { }

  public displayAllCandidate(): Observable<any> {
    return this.http.get("http://localhost:8082/coda/displayAllCandidate");
  }

  public addVote(candidateId): Observable<any>{
    return this.http.get("http://localhost:8082/coda/vote/"+candidateId);
  }

  public displayAllVotes():Observable<any>{
    return this.http.get("http://localhost:8082/coda/displayAllVotes");
  }
}
