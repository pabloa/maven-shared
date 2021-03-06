package org.apache.maven.shared.project.install;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;

import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.shared.artifact.install.ArtifactInstallerException;
import org.apache.maven.shared.project.NoFileAssignedException;

/**
 * This defines the interface to install a single Maven Project.
 * 
 * @author Karl Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 */
public interface ProjectInstaller
{
    /**
     * This will install a single project which may contain several artifacts. Those artifacts will be installed into
     * the appropriate repository.
     * 
     * <pre class="java">
     *  @Parameter( defaultValue = "${session}", required=true, readonly = true)
     *  MavenSession session;
     *  @Parameter( defaultValue = "${project}", required=true, readonly = true)
     *  MavenProject project;
     *  ..
     *  &#64;Component
     *  ProjectInstaller installer;
     *  
     *    ProjectInstallerRequest pir =
     *      new ProjectInstallerRequest()
     *         .setProject( mavenProject )
     *         .setCreateChecksum( false )
     *         .setUpdateReleaseInfo( false );
     *  
     *  installer.install (session.getProjectBuildingRequest(), pir, artifactRepository);
     * </pre>
     * 
     * 
     * @param projectBuildingRequest {@link ProjectBuildingRequest}
     * @param projectInstallerRequest {@link ProjectInstallerRequest}
     * @param artifactRepository {@link ArtifactRepository}
     * @throws IOException In case of problems related to checksums.
     * @throws ArtifactInstallerException In case of problems to install artifacts.
     * @throws NoFileAssignedException If no file has been assigned to the project.
     */
    void install( ProjectBuildingRequest projectBuildingRequest, ProjectInstallerRequest projectInstallerRequest,
                         ArtifactRepository artifactRepository )
        throws IOException, ArtifactInstallerException, NoFileAssignedException;

}
