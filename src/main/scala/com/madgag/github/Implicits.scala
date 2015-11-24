/*
 * Copyright 2015 Roberto Tyley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.madgag.github

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.{Success, Try}

object Implicits {
  implicit class RichFuture[S](f: Future[S]) {
    lazy val trying = {
      val p = Promise[Try[S]]()
      f.onComplete { case t => p.complete(Success(t)) }
      p.future
    }
  }

//  implicit class RichGitUser(user: GitUser) {
//
//    lazy val ident = Ident(user.getName, user.getEmail)
//
//  }
//
//  implicit class RichGHMyself(myself: GHMyself) {
//    private val emails = myself.getEmails2
//
//    lazy val primaryEmail = emails.find(_.isPrimary).get
//
//    lazy val ident = Ident(myself.displayName, primaryEmail.getEmail)
//
//    lazy val verifiedEmails: Seq[GHEmail] = emails.filter(_.isVerified)
//  }
//
//  implicit class RichIssue(issue: GHIssue) {
//    lazy val assignee = Option(issue.getAssignee)
//
//    lazy val labelNames = issue.getLabels.map(_.getName)
//  }
//
//  implicit class RichRepository(repo: GHRepository) {
//    lazy val id = RepoId(repo.getOwnerName, repo.getName)
//  }
//
//  implicit class RichPullRequest(pr: GHPullRequest) {
//    lazy val id = PullRequestId(pr.getRepository.id, pr.getNumber)
//  }
//
//
//  // val dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
//
//  implicit class RichPerson(person: GHPerson) {
//
//    lazy val createdAt = new DateTime(person.getCreatedAt)
//
//    lazy val atLogin = s"@${person.getLogin}"
//
//    lazy val name = Option(person.getName)
//
//    lazy val displayName = name.filter(_.nonEmpty).getOrElse(atLogin)
//
//  }
//
//  implicit class RichGHCommitPointer(commitPointer: GHCommitPointer) {
//    lazy val objectId = commitPointer.getSha.asObjectId
//  }
//
//  implicit class RichGHPullRequestCommitDetail(prCommitDetail: GHPullRequestCommitDetail) {
//    lazy val objectId = prCommitDetail.getSha.asObjectId
//  }
}
