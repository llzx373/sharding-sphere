/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.core.keygen;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KeyGeneratorTypeTest {
    
    @Test
    public void assertGetKeyGeneratorType() {
        assertThat(KeyGeneratorType.getKeyGeneratorType("io.shardingsphere.core.keygen.generator.SnowflakeKeyGenerator"), 
                is(Optional.of(KeyGeneratorType.SNOWFLAKE)));
        assertThat(KeyGeneratorType.getKeyGeneratorType("io.shardingsphere.core.keygen.generator.UUIDKeyGenerator"),
                is(Optional.of(KeyGeneratorType.UUID)));
        assertThat(KeyGeneratorType.getKeyGeneratorType(""),
                is(Optional.of(KeyGeneratorType.LEAF)));
        assertThat(KeyGeneratorType.getKeyGeneratorType("test"),
                is(Optional.<KeyGeneratorType>absent()));
    }
}
