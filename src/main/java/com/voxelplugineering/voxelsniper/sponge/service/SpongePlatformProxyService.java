/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 The Voxel Plugineering Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.voxelplugineering.voxelsniper.sponge.service;

import java.io.File;

import com.google.common.base.Optional;
import com.voxelplugineering.voxelsniper.CommonPlatformProxyService;
import com.voxelplugineering.voxelsniper.core.Gunsmith;

/**
 * A proxy for sponge-specific runtime values.
 */
public class SpongePlatformProxyService extends CommonPlatformProxyService
{

    private org.spongepowered.api.Game game;

    /**
     * Creates a new {@link SpongePlatformProxyService}.
     * 
     * @param game The game instance
     */
    public SpongePlatformProxyService(org.spongepowered.api.Game game)
    {
        super(new File("", "VoxelSniper"));
        this.game = game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void init()
    {
        super.init();
        Gunsmith.getLogger().info("Initialized SpongePlatformProxy service");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void destroy()
    {
        super.destroy();
        Gunsmith.getLogger().info("Stopped SpongePlatformProxy service");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlatformName()
    {
        return "Sponge";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion()
    {
        return String.format("%s %s", "Sponge", this.game.getImplementationVersion());//TODO add MC version
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFullVersion()
    {
        return "Sponge version " + this.game.getImplementationVersion() + " implementing api version " + this.game.getApiVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumberOfPlayersOnline()
    {
        Optional<org.spongepowered.api.Server> server = this.game.getServer();
        if (server.isPresent())
        {
            return server.get().getOnlinePlayers().size();
        } else
        {
            return 0;
        }
    }

    /**
     * Returns sponge's {@link org.spongepowered.api.Game} instance.
     * 
     * @return The game
     */
    public org.spongepowered.api.Game getGame()
    {
        return this.game;
    }

}
