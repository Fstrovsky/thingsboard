/**
 * Copyright © 2016-2019 The Thingsboard Authors
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
package org.thingsboard.server.common.data.edge;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.thingsboard.server.common.data.HasCustomerId;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.SearchTextBasedWithAdditionalInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@Setter
public class Edge extends SearchTextBasedWithAdditionalInfo<EdgeId> implements HasName, HasTenantId, HasCustomerId {

    private static final long serialVersionUID = 4934987555236873728L;

    private TenantId tenantId;
    private CustomerId customerId;
    private String name;
    private transient JsonNode configuration;
    private transient JsonNode additionalInfo;

    public Edge() {
        super();
    }

    public Edge(EdgeId id) {
        super(id);
    }

    public Edge(Edge edge) {
        super(edge);
        this.tenantId = edge.getTenantId();
        this.customerId = edge.getCustomerId();
        this.name = edge.getName();
        this.configuration = edge.getConfiguration();
        this.additionalInfo = edge.getAdditionalInfo();
    }

    @Override
    public String getSearchText() {
        return getName();
    }
}