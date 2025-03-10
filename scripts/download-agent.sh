#!/usr/bin/env bash

VERSION=v2.11.0

# Define the URL of the Grafana OpenTelemetry agent
AGENT_URL="https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/${VERSION}/opentelemetry-javaagent.jar"

# Define the path to the instrumentation directory
#INSTRUMENTATION_DIR="$(dirname "$(dirname "${BASH_SOURCE[0]}")")/instrumentation"

INSTRUMENTATION_DIR="$(dirname "${BASH_SOURCE[0]}")/../instrumentation"

# Create the instrumentation directory if it doesn't exist
mkdir -p "$INSTRUMENTATION_DIR"

# Download the Grafana OpenTelemetry agent and save it in the instrumentation directory
curl -L "$AGENT_URL" -o "$INSTRUMENTATION_DIR/opentelemetry-javaagent.jar"

# Print a success message
echo "OpenTelemetry Java agent downloaded successfully in $INSTRUMENTATION_DIR"