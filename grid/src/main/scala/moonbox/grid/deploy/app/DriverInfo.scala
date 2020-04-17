/*-
 * <<
 * Moonbox
 * ==
 * Copyright (C) 2016 - 2019 EDP
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package moonbox.grid.deploy.app

import java.util.Date

import moonbox.grid.deploy.master.WorkerInfo
import org.apache.hadoop.yarn.api.records.ApplicationId


class DriverInfo(
                  val submitTime: Long,
                  val id: String,
                  val desc: DriverDesc,
                  val submitDate: Date) extends Serializable {

  @transient var state: DriverState.Value = DriverState.WAITING

  @transient var exception: Option[Exception] = None

  @transient var worker: Option[WorkerInfo] = None

  @transient var appId: Option[String] = None

  @transient var appIdInfo: Option[ApplicationId] = None

  @transient var startDate: Option[Date] = None

  @transient var finishDate: Option[Date] = None

  init()

  def setStartDate(time: Long): Unit = {
    if (time != 0)
      Some(new Date(time))
    else this.startDate = null
  }

  def setFinishDate(time: Long): Unit = {
    if (time != 0)
      Some(new Date(time))
    else this.finishDate = null
  }

  def setException(msg: String): Unit = {
    if (msg != null)
      this.exception = Some(new Exception(msg))
  }

  private def init(): Unit = {
    state = DriverState.WAITING
    worker = None
    exception = None
    appId = None
  }

  private def readObject(in: java.io.ObjectInputStream): Unit = {
    in.defaultReadObject()
    init()
  }

  override def toString: String = {
    s"""startTime: $submitTime
       		   |id: $id
       		   |desc: $desc
       		   |submitDate: $submitDate
       		   |state: $state
       		   |appId: $appId
		 """.stripMargin
  }
}
