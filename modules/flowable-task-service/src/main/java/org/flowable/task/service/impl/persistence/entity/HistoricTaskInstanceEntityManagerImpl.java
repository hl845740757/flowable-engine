/* Licensed under the Apache License, Version 2.0 (the "License");
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
 */

package org.flowable.task.service.impl.persistence.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.service.TaskServiceConfiguration;
import org.flowable.task.service.impl.HistoricTaskInstanceQueryImpl;
import org.flowable.task.service.impl.persistence.entity.data.HistoricTaskInstanceDataManager;

/**
 * @author Tom Baeyens
 * @author Joram Barrez
 */
public class HistoricTaskInstanceEntityManagerImpl
        extends AbstractTaskServiceEntityManager<HistoricTaskInstanceEntity, HistoricTaskInstanceDataManager>
        implements HistoricTaskInstanceEntityManager {

    public HistoricTaskInstanceEntityManagerImpl(TaskServiceConfiguration taskServiceConfiguration, HistoricTaskInstanceDataManager historicTaskInstanceDataManager) {
        super(taskServiceConfiguration, historicTaskInstanceDataManager);
    }

    @Override
    public HistoricTaskInstanceEntity create(TaskEntity task) {
        return dataManager.create(task);
    }
    
    @Override
    public List<HistoricTaskInstanceEntity> findHistoricTasksByParentTaskId(String parentTaskId) {
        return dataManager.findHistoricTasksByParentTaskId(parentTaskId);
    }
    
    @Override
    public List<String> findHistoricTaskIdsByParentTaskIds(Collection<String> parentTaskIds) {
        return dataManager.findHistoricTaskIdsByParentTaskIds(parentTaskIds);
    }

    @Override
    public List<HistoricTaskInstanceEntity> findHistoricTasksByProcessInstanceId(String processInstanceId) {
        return dataManager.findHistoricTasksByProcessInstanceId(processInstanceId);
    }

    @Override
    public List<String> findHistoricTaskIdsForProcessInstanceIds(Collection<String> processInstanceIds) {
        return dataManager.findHistoricTaskIdsForProcessInstanceIds(processInstanceIds);
    }

    @Override
    public List<String> findHistoricTaskIdsForScopeIdsAndScopeType(Collection<String> scopeIds, String scopeType) {
        return dataManager.findHistoricTaskIdsForScopeIdsAndScopeType(scopeIds, scopeType);
    }

    @Override
    public long findHistoricTaskInstanceCountByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return dataManager.findHistoricTaskInstanceCountByQueryCriteria(historicTaskInstanceQuery);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<HistoricTaskInstance> findHistoricTaskInstancesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return dataManager.findHistoricTaskInstancesByQueryCriteria(historicTaskInstanceQuery);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<HistoricTaskInstance> findHistoricTaskInstancesAndRelatedEntitiesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return dataManager.findHistoricTaskInstancesAndRelatedEntitiesByQueryCriteria(historicTaskInstanceQuery);
    }

    @Override
    public List<HistoricTaskInstance> findHistoricTaskInstancesByNativeQuery(Map<String, Object> parameterMap) {
        return dataManager.findHistoricTaskInstancesByNativeQuery(parameterMap);
    }

    @Override
    public long findHistoricTaskInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        return dataManager.findHistoricTaskInstanceCountByNativeQuery(parameterMap);
    }
    
    @Override
    public void deleteHistoricTaskInstances(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        dataManager.deleteHistoricTaskInstances(historicTaskInstanceQuery);
    }
    
    @Override
    public void bulkDeleteHistoricTaskInstancesForIds(Collection<String> taskIds) {
        dataManager.bulkDeleteHistoricTaskInstancesForIds(taskIds);
    }

    @Override
    public void deleteHistoricTaskInstancesForNonExistingProcessInstances() {
        dataManager.deleteHistoricTaskInstancesForNonExistingProcessInstances();
    }
    
    @Override
    public void deleteHistoricTaskInstancesForNonExistingCaseInstances() {
        dataManager.deleteHistoricTaskInstancesForNonExistingCaseInstances();
    }

    public HistoricTaskInstanceDataManager getHistoricTaskInstanceDataManager() {
        return dataManager;
    }

    public void setHistoricTaskInstanceDataManager(HistoricTaskInstanceDataManager historicTaskInstanceDataManager) {
        this.dataManager = historicTaskInstanceDataManager;
    }

}
