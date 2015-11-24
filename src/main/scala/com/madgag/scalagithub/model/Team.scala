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

package com.madgag.scalagithub.model

import play.api.libs.json.Json


case class Team(
  id: Long,
  name: String,
  slug: String,
  members_count: Int,
  organization: Team.Org
) {
  val atSlug = "@" + slug
}

object Team {

  /*
  In a Team listing:

  "organization": {
        "login": "github",
        "id": 1,
        "url": "https://api.github.com/orgs/github",
        "avatar_url": "https://github.com/images/error/octocat_happy.gif",
        "description": "A great organization"
      }
   */
  case class Org(login: String, id: Long, url: String, avatar_url: String, description: Option[String])

  object Org {
    implicit val readsOrg = Json.reads[Org]
  }

  implicit val readsTeam = Json.reads[Team]

}

