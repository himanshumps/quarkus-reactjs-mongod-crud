# dev stage
FROM node:18.12-alpine3.17 as dev

ENV NODE_ENV=development
ENV NODE_OPTIONS="--openssl-legacy-provider"
EXPOSE 8080

ENV PORT 8080

# setup workdir (next commands will run under this context, but also the running container will inherit this - if not overriden at runtime)

WORKDIR /home/react/frontend
RUN chown -R node:node /home/react
USER node
# - copy the rest of the code (except the ones in .dockerignore) (optimise image build - we expect these to change everytime, so keep this as late as possible)
COPY --chown=node:node . .


# - install packages (optimise image build - run just install after copying package.json, we hope these will change rarer as the code, so we can reuse this image layer too)
RUN npm install

CMD ["npm", "start"]

