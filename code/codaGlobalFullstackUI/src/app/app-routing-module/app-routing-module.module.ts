import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { DisplayCandidatesComponent } from '../display-candidates/display-candidates.component';
import { VoteComponent } from '../vote/vote.component';

const approutes:Routes=[
  {path:'',component:DisplayCandidatesComponent},
  {path:'vote/:candidateId', component: VoteComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(approutes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModuleModule { }
