/*
 * Copyright 2013 Moving Blocks
 *
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
 */

package org.terasology.entitySystem.persistence;

import org.terasology.entitySystem.Component;
import org.terasology.entitySystem.EntityInfoComponent;
import org.terasology.entitySystem.metadata.ComponentMetadata;

/**
 * Interface for checks as whether a component should be serialized
 *
 * @author Immortius
 */
public interface ComponentSerializeCheck {

    boolean serialize(ComponentMetadata<? extends Component> metadata);

    public static class NullCheck implements ComponentSerializeCheck {
        private static NullCheck instance = new NullCheck();

        public static ComponentSerializeCheck create() {
            return instance;
        }

        private NullCheck() {
        }

        @Override
        public boolean serialize(ComponentMetadata<? extends Component> metadata) {
            return metadata.getType() != EntityInfoComponent.class;
        }
    }
}