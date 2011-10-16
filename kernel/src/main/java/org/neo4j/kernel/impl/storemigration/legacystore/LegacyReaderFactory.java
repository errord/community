/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.storemigration.legacystore;

import java.io.IOException;
import java.nio.channels.FileChannel;

import org.neo4j.kernel.impl.nioneo.store.PersistenceWindowPool;
import org.neo4j.kernel.impl.nioneo.store.WindowPool;

public class LegacyReaderFactory implements ReaderFactory
{
    @Override
    public NodeStoreReader newLegacyNodeStoreReader( String fileName ) throws IOException
    {
        return new LegacyNodeStoreReader( fileName );
    }

    @Override
    public RelationshipStoreReader newLegacyRelationshipStoreReader( String fileName ) throws IOException
    {
        return new LegacyRelationshipStoreReader( fileName );
    }

    @Override
    public WindowPool newPersistenceWindowPool( String fileName, int recordLength, FileChannel fileChannel, long mappedMem, boolean useMemoryMappedBuffers, boolean readOnly )
    {
        return new PersistenceWindowPool( fileName, recordLength, fileChannel, mappedMem, useMemoryMappedBuffers, readOnly );
    }
}
