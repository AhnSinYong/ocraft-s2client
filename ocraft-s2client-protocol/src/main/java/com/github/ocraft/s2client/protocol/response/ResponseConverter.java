package com.github.ocraft.s2client.protocol.response;

/*-
 * #%L
 * ocraft-s2client-protocol
 * %%
 * Copyright (C) 2017 - 2018 Ocraft Project
 * %%
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
 * #L%
 */

import SC2APIProtocol.Sc2Api;

import java.util.function.Function;

import static com.github.ocraft.s2client.protocol.Preconditions.require;

public class ResponseConverter implements Function<Sc2Api.Response, Response> {
    @Override
    public Response apply(Sc2Api.Response sc2ApiResponse) {
        require("sc2api response", sc2ApiResponse);
        if (sc2ApiResponse.getErrorCount() > 0) {
            return ResponseError.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasPing()) {
            return ResponsePing.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasAvailableMaps()) {
            return ResponseAvailableMaps.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasCreateGame()) {
            return ResponseCreateGame.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasJoinGame()) {
            return ResponseJoinGame.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasLeaveGame()) {
            return ResponseLeaveGame.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasRestartGame()) {
            return ResponseRestartGame.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasQuit()) {
            return ResponseQuitGame.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasStartReplay()) {
            return ResponseStartReplay.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasReplayInfo()) {
            return ResponseReplayInfo.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasObservation()) {
            return ResponseObservation.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasStep()) {
            return ResponseStep.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasAction()) {
            return ResponseAction.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasQuickSave()) {
            return ResponseQuickSave.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasQuickLoad()) {
            return ResponseQuickLoad.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasSaveMap()) {
            return ResponseSaveMap.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasSaveReplay()) {
            return ResponseSaveReplay.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasDebug()) {
            return ResponseDebug.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasGameInfo()) {
            return ResponseGameInfo.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasQuery()) {
            return ResponseQuery.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasData()) {
            return ResponseData.from(sc2ApiResponse);
        }
        if (sc2ApiResponse.hasObsAction()) {
            return ResponseObserverAction.from(sc2ApiResponse);
        }
        throw new AssertionError("unknown response");
    }
}
