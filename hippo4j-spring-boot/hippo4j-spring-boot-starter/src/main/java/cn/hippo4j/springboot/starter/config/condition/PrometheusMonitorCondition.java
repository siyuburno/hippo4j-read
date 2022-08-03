/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.springboot.starter.config.condition;

import cn.hippo4j.common.toolkit.StringUtil;
import cn.hippo4j.springboot.starter.config.BootstrapProperties;
import com.example.monitor.base.MonitorTypeEnum;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Prometheus monitor condition.
 */
public class PrometheusMonitorCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String collectType = context.getEnvironment().getProperty(BootstrapProperties.PREFIX + ".collect-type", "");
        return StringUtil.isNotEmpty(collectType) && collectType.contains(MonitorTypeEnum.PROMETHEUS.name().toLowerCase()) ? true : false;
    }
}